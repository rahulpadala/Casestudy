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
  specification: key<string,string>;
  cost:String;
}

export interface key<K, V> {
  key: K
  value: V
}
