<template>
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h3 class="pt-3">Brands</h3>
          <!-- <router-link id="add-category" :to="{name : 'AddCategory'}" v-show="$route.name=='AdminCategory'">
            <button class="btn">Add a new Brand</button>
          </router-link> -->
        </div>
      </div>
      <div class="row">
        <div v-for="brand of brands" :key="brand.id" class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
          <BrandsBox :brands="brand">
          </BrandsBox>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import BrandsBox from '../../components/Brands/BrandsBox';
  var axios =  require('axios');
  export default {
    // eslint-disable-next-line vue/multi-word-component-names
    name: "Brands",
    components : {BrandsBox},
    data() {
      return {
        baseURL : "//localhost:8080/",
        brands : null,
      }
    },
    methods: {
      async getBrands() {
        //fetch categories
        await axios.get(this.baseURL + "brand/")
        .then(res => this.brands = res.data)
        .catch(err => console.log(err))
      }
    },
    mounted(){
      this.getBrands();
    }
  }
  </script>
  
  <style scoped>
  h4 {
    font-family: 'Roboto', sans-serif;
    color: #484848;
    font-weight: 700;
  }
  
  #add-category {
    float: right;
    font-weight: 500;
  }
  </style>