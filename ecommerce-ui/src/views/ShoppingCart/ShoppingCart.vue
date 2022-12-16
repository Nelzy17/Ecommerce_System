<template>
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h3 class="pt-3">Shopping Cart</h3>
        </div>
      </div>
      
      <div v-for="shoppingCartItem in shoppingCartItems" :key="shoppingCartItem.product.productId" class="row mt-2 pt-3 justify-content-around">
        <div class="col-2"></div>
       
        <div class="col-md-3 embed-responsive embed-responsive-16by9">
          <router-link :to="{ name: 'ShowDetails', params: { id : shoppingCartItem.product.productId } }">
            <img v-bind:src="shoppingCartItem.product.imageURL" class="w-100 card-img-top embed-responsive-item">
          </router-link>
        </div>
        
        <div class="col-md-5 px-3">
          <div class="card-block px-3">
            <h6 class="card-title"><router-link :to="{ name: 'ShowDetails', params: { id : shoppingCartItem.product.productId } }">{{shoppingCartItem.product.productName}} </router-link></h6>
            <p id="item-price" class="mb-0 font-weight-bold">$ {{shoppingCartItem.product.price}} per unit</p>
            <p id="item-quantity" class="mb-0">
              Quantity :
              <input size="1" class="p-0 h-25 border-bottom border-top-0 border-left-0 border-right-0" v-model="shoppingCartItem.quantity" /></p>
            <p id="item-total-price" class="mb-0">Total : <span class="font-weight-bold"> $ {{shoppingCartItem.product.price*shoppingCartItem.quantity}}</span></p>
            
<br><a href="#" @click="deleteItem(shoppingCartItem.id)">Remove From Shopping Cart</a>
        </div>
        </div>
        <div class="col-2"></div>
        <div class="col-12"><hr></div>
      </div>
  
      
      <div class="total-cost pt-2 text-right">
        <h5>Total : $ {{totalcost}}</h5>
        <router-link :disabled="isDisabled()" type="button" class="btn btn-primary confirm" :to="{name : 'Checkout'}" >Proceed To Pay</router-link>
      </div>
    </div>
  </template>
  
  <script>
  const axios = require('axios')
  export default {
    data() {
      return {
        shoppingCartItems: [],
        userName: null,
        totalcost:0
      }
    },
    // eslint-disable-next-line vue/multi-word-component-names
    name: 'ShoppingCart',
    props: ["baseURL"],
    methods: {
       isDisabled(){
         if(this.shoppingCartItems.length === 0){
           return true;
         }
         return false;
       },
      
      listCartItems(){
        axios.get(`${this.baseURL}shoppingcart/?UserName=${this.userName}`).then((response) => {
          if(response.status==200){
            const result = response.data;
            this.shoppingCartItems = result.cartItems;
            this.totalcost = result.totalCost
          }
        },
        (error)=>{
          console.log(error)
        });
      },
      
    deleteItem(itemId) {
      axios.delete(`${this.baseURL}shoppingcart/delete/${itemId}/?userName=${this.userName}`)
        .then((response)=>{
          if(response.status == 200){
            this.listCartItems();
          }
        },(error)=>{
          console.log(error)
        })
    }
    },
  
    mounted() {
      this.userName = localStorage.getItem("userName");
      this.listCartItems();
    },
  };
  
  </script>
  
  <style scoped>
  h4, h5 {
    font-family: 'Roboto', sans-serif;
    color: #484848;
    font-weight: 700;
  }
  
  .embed-responsive .card-img-top {
    object-fit: cover;
  }
  
  #item-price {
    color: #232F3E;
  }
  
  #item-quantity{
    float: left;
  }
  
  #item-total-price {
    float: right;
  }
  
  .confirm {
    font-weight: bold;
    font-size: larger;
  }
  
  </style>
  