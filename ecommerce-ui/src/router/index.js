import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/HomeView.vue'
import Category from "../views/Category/Category";
import AddProduct from "../views/Product/AddProduct";
import Product from "../views/Product/Product";

import Register from "../views/Register";
import Login from "../views/Login";
import ShowDetails from "../views/Product/ShowDetails";
import Brands from "../views/Brands/Brands";
import ShoppingCart from "../views/ShoppingCart/ShoppingCart";
import ProductByCat from "../views/Product/ProductByCat";
import ProductByBrand from "../views/Product/ProductByBrand";
import Analytics from "../views/Analytics";
import Checkout from "../views/Checkout/Checkout"





const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/admin/category",
    name: "AdminCategory",
    component: Category,
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
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
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
    path : '/admin/shoppingcart',
    name : 'ShoppingCart',
    component: ShoppingCart
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
  {
    path: '/analytics',
    name: 'Analytics',
    component: Analytics
  },
  {
    path: '/checkout',
    name: 'Checkout',
    component: Checkout
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
