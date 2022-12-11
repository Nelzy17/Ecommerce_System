<template>
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h4 class="pt-3"> Products</h4>
        </div>
      </div>
      <div class="row">
          <div v-for= "product of products" :key="product.productId" class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
            <ProductBox :product="product">
            </ProductBox>
          </div>
      </div>
    </div>
  </template>
  
  <script>
  import ProductBox from '../../components/Product/ProductBox';
  const axios = require('axios')
  export default {
    // eslint-disable-next-line vue/multi-word-component-names
    name: 'ProductByBrand',
    data() {
        return {
          products: null,
          brandId: null,
        };
    },
    components : {ProductBox},
    props : [ "baseURL" ],
    methods: {
    // fetch all the items in cart
     listproductsbyCategory(){
      axios.get(`${this.baseURL}/product/brand?brandId=${this.brandId}`).then((response) => {
        if(response.status==200){
          const result = response.data;
          // store cartitems and total price in two variables
          this.products = result;
        }
      },
      (error)=>{
        console.log(error)
      });
    },
  },
    mounted(){
      this.brandId = this.$route.params.id;
      this.listproductsbyCategory()
    }
  }
  </script>
  
  <style scoped>
  
  .card{
    width : 20rem;
    height : 24rem;
  }
  
  h4 {
    font-family: 'Roboto', sans-serif;
    color: #484848;
    font-weight: 700;
  }
  
  #add-product {
    float: right;
    font-weight: 500;
  }
  </style>
  