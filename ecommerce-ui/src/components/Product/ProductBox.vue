<template>
    <div class="card h-100">
      <div class="embed-responsive embed-responsive-16by9">
        <router-link :to="{ name: 'ShowDetails', params: { id : product.productId } }"><img class="card-img-top embed-responsive-item" :src="product.imageURL" alt="Product Image"></router-link>
      </div>
      <div class="card-body">
        <router-link :to="{ name: 'ShowDetails', params: { id : product.productId } }"><h5 class="card-title">{{product.productName}}</h5></router-link>
        <p class="card-text"><sup>$</sup>{{product.price}}</p>
      </div>
    </div>
</template>
  
<script>
  export default {
      name : "ProductBox",
      props : ["product"],
      methods : {
      }
  }
</script>
  
<style scoped>
  
  .embed-responsive .card-img-top {
    object-fit: cover;
  }
  
  .card-title {
    color: #484848;
    font-size: 1.1rem;
    font-weight: 400;
  }
  
  .card-title:hover {
    font-weight: bold;
  }
  
  .card-text {
    font-size: 1.2rem;
  }

</style>
  