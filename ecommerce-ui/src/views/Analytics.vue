<template>
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h1 class="pt-3">Analytics</h1>
        </div>
      </div>
  
      <div class="row">
        <div class="col-3"></div>
        <div class="col-md-6 px-5 px-md-0">
            <div class="form-group">
              <h5> Total Number of Users: </h5>
              <span>{{analytics.users}}</span>
            </div>
            <div class="form-group">
              <h5> Total Number of Products Sold: </h5>
              <span>{{analytics.productsSold}}</span>
            </div>
            <div class="form-group">
              <h5> Total Revenue Generated: </h5>
              <span>${{analytics.totalRevenue}}</span>
            </div>
            <div class="form-group">
              <h5> Most Selling Product: </h5>
              <span>{{analytics.product}}</span>
            </div>
            <div class="form-group">
              <h5> Most Selling Category: </h5>
              <span>{{analytics.category}}</span>
            </div>
            <div class="form-group">
              <h5> Most Selling Brand: </h5>
              <span>{{analytics.brand}}</span>
            </div>
        </div>
        <div class="col-3"></div>
      </div>
    </div>
  </template>
  
  <script>
  var axios = require('axios')
  
  export default {
    // eslint-disable-next-line vue/multi-word-component-names
    name: 'Analytics',
    data() {
        return {
          analytics: {},
        };
    },
    props : [ "baseURL" ],
    methods: {
    
     getAnalytics(){
      axios.get(`${this.baseURL}/analytics/`).then((response) => {
        if(response.status==200){
          const result = response.data;
          this.analytics = result;
        }
      },
      (error)=>{
        console.log(error)
      });
    },
  },
    mounted(){
      this.getAnalytics()
    }
  }
  </script>
  
  <style scoped>
  h5 {
    font-family: 'Roboto', sans-serif;
    color: #484848;
    font-weight: 700;
  }

  h1{
    font-family: 'Roboto', sans-serif;
    color: #484848;
    font-weight: 700;
    margin-bottom: 2rem !important;
  }
  
  </style>
  