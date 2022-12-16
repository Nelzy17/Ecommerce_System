<template>
    <div class="card h-100">
      <div class="card-body">
        <router-link :to="{ name: 'ProductByBrand', params: { id : brands.id } }"><h5 class="card-title">{{brands.brandModel}}</h5></router-link>
      </div>
    </div>
  </template>
  
  <script>
  export default {
      name : "BrandsBox",
      props : ["brands"],
      methods : {
      }
  }
  </script>
  
  <style scoped>
  
  .card{
    width : 20rem;
    height : 24rem;
  }
  
  .card-title {
    color: #484848;
    font-size: 1.1rem;
    font-weight: 400;
  }
  
  .card-title:hover {
    font-weight: bold;
  }
  
</style>
  