<template>
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h1 class="pt-3"> Checkout </h1>
        </div>
      </div>

      <div class="row">
        <div class="col-12 text-center">
          <h4 class="pt-3">Payment Details</h4>
        </div>
      </div>
 
      <div class="row">
        <div class="col-3"></div>
        <div class="col-md-6 px-5 px-md-0">
         <form>
           <div class="form-group">
             <label>Full Name</label>
             <input type="text" class="form-control"  required>
           </div>
           <div class="form-group">
             <label>Card Number</label>
             <input type="number" class="form-control"  required>
           </div>
           <div class="form-group">
             <label>CVV</label>
             <input type="number" class="form-control" required>
           </div>
           <div class="form-group">
             <label>Expiry Date</label>
             <input type="date" class="form-control" required>
           </div>
         </form>
        </div>
        <div class="col-3"></div>
      </div>
      <div class="col-12"><hr></div>

    <div class="row">
        <div class="col-12 text-center">
          <h4 class="pt-3">Order Details</h4>
        </div>
      </div>
      <div v-for="cartItem in cartItems" :key="cartItem.product.productId" class="row mt-2 pt-3 justify-content-around">
        <div class="col-2"></div>
       
        <div class="col-md-3 embed-responsive embed-responsive-16by9">
          
            <img v-bind:src="cartItem.product.imageURL" class="w-100 card-img-top embed-responsive-item">
          
        </div>
       
        <div class="col-md-5 px-3">
          <div class="card-block px-3">
            <h6 class="card-title">{{cartItem.product.productName}}</h6>
            <p id="item-price" class="mb-0 font-weight-bold">$ {{cartItem.product.price}} per unit</p>
            <p id="item-quantity" class="mb-0">
              Quantity :
              <span size="1" class="p-0 h-25 border-bottom border-top-0 border-left-0 border-right-0">{{cartItem.quantity}}</span></p>
            <p id="item-total-price" class="mb-0">Total : <span class="font-weight-bold"> $ {{cartItem.product.price*cartItem.quantity}}</span></p>
            
        </div>
        </div>
        <div class="col-2"></div>
        
      </div>
  
      <!-- display total price -->
      <div class="total-cost pt-2 text-right">
        <h5>Total : $ {{totalcost}}</h5>
        <button :disabled="isDisabled()" @click="orderConfirmed()" type="button" class="btn btn-primary confirm" >Confirm Order</button>
      </div>
    </div>
  </template>
  
  <script>
  const axios = require('axios')
  import swal from 'sweetalert';
  export default {
    data() {
      return {
        cartItems: [],
        userName: null,
        totalcost:0
      }
    },
    // eslint-disable-next-line vue/multi-word-component-names
    name: 'Checkout',
    props: ["baseURL"],
    methods: {
       isDisabled(){
         if(this.cartItems.length === 0){
           return true;
         }
         return false;
       },
      
      listCheckoutItems(){
        axios.get(`${this.baseURL}checkout/?UserName=${this.userName}`).then((response) => {
          if(response.status==200){
            const result = response.data;
            
            this.cartItems = result.cartItems;
            this.totalcost = result.totalCost
          }
        },
        (error)=>{
          console.log(error)
        });
      },
      orderConfirmed(){
        axios.post(`${this.baseURL}checkout/add?UserName=${this.userName}`).then(() => {
            swal({
            text: "Order Confirmed",
            icon: "success"
            });
            this.$router.push({name:'Home'});
            
          
        },
        (error)=>{
          console.log(error)
        });
      }
    },
  
    mounted() {
      this.userName = localStorage.getItem("userName");
      this.listCheckoutItems();
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
  