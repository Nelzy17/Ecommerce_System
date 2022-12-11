<template>
  <div id="app">
    <div id="nav">
      <Navbar />
    </div>
    <div style="min-height: 60vh">
      <router-view v-if="(products && categories && brands)"
         :baseURL="baseURL"
         :products="products"
         :categories="categories"
         :brands = "brands"
         @fetchData = "fetchData">
      </router-view>
    </div>
    <Footer />
  </div>
</template>

<script>
import Navbar from "./components/Navbar.vue"
import Footer from "./components/Footer.vue"


const axios = require('axios');
export default {
  data() {
    return {
      baseURL : "//localhost:8080/",
      products : null,
      categories : null,
      brands : null
    }
  },

  components : {Navbar, Footer},
  methods : {
    async fetchData() {
      // fetch products
      await axios.get(this.baseURL + "product/")
              .then(res => this.products = res.data)
              .catch(err => console.log(err))

      //fetch categories
      await axios.get(this.baseURL + "category/")
              .then(res => this.categories = res.data)
              .catch(err => console.log(err))
      
      await axios.get(this.baseURL + "brand/")
      .then(res => this.brands = res.data)
      .catch(err => console.log(err))
    }
  },
  mounted() {
    this.fetchData();
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

