export interface Product {
  productId: number;
  productType: string;
  productName: string;
  category: string;
  rating: Map<number,number>,
  review: Map<number,string>,
  image: Array<string>,
  price:number,
  description:string,
  specification: KeyValue<string,string>,
  cost:String
}

interface KeyValue<K, V> {
  key: K
  value: V
}
