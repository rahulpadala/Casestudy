export interface CartItem
{
    cartId : number;
    totalPrice : number;
    items : Array<Items>;
}

export interface Items
{
    ProductName : string,
    productId:number,
    image : string,
    price : number,
    quantity: number
}
