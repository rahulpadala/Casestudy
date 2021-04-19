export interface Orders{
    orderId : number;
    orderDate : Date;
    amount : number;
    modeOfPayment : string;
    orderStatus : string;
    quantity : number;
    address : Address;
    product : Array<Product>;

}

export interface Address{
    customerId : number;
    fullName : string;
    mobileNumber : string;
    flatNumber: number;
    city : string;
    pincode : number;
    state : string;
}

export interface Product {
    productId: number;
    productName: string;
    img : string;
    price : number;
    quantity : number;
  }