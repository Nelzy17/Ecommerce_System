import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/HomeView.vue'
import AddCategory from "../views/Category/AddCategory";
import Category from "../views/Category/Category";
import EditCategory from "../views/Category/EditCategory";
import AddProduct from "../views/Product/AddProduct";
import Product from "../views/Product/Product";

import Signup from "../views/Signup";
import Signin from "../views/Signin";
import ShowDetails from "../views/Product/ShowDetails";
import Brands from "../views/Brands/Brands";
import Cart from "../views/cart/Cart";
import ProductByCat from "../views/Product/ProductByCat";
import ProductByBrand from "../views/Product/ProductByBrand"





const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/admin/category/add",
    name: "AddCategory",
    component: AddCategory,
  },
  {
    path: "/admin/category",
    name: "AdminCategory",
    component: Category,
  },
  {
    path: "/admin/category/:id",
    name: "EditCategory",
    component: EditCategory,
  },
  {
    path: "/admin/product/add",
    name: "AddProduct",
    component: AddProduct,
  },
  {
    path: "/admin/product",
    name: "AdminProduct",
    component: Product,
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
  },
  {
    path: '/signin',
    name: 'Signin',
    component: Signin
  },
  {
    path : '/product/show/:id',
    name : 'ShowDetails',
    component: ShowDetails
  },
  {
    path : '/admin/brand',
    name : 'BrandCategory',
    component: Brands
  },
  {
    path : '/admin/cart',
    name : 'Cart',
    component: Cart
  },
  {

    path : '/product/category/:id',
    name : 'ProductByCat',
    component: ProductByCat
  },
  {
    path : '/product/brand/:id',
    name : 'ProductByBrand',
    component: ProductByBrand
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
