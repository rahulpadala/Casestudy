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
    productType: string;
    productName: string;
    category: string;
    rating: Map<number,number>;
    review: Map<number,string>;
    image1 : string;
    image2 : string;
    image3 : string;
    image4 : string;
    price:number;
    description:string;
    cost:String;
  }