<template>
    <div class="container">
        <div class="row pt-5">
            <!--            Leave some empty space in left-->
            <div class="col-md-1">
            </div>
            <!--                Display the image in left side-->
            <div class="col-md-4 col-12">
                <img :src="product.imageURL" :alt="product.productName" class="img-fluid">
            </div>
            <!-- Display product name category name and product description-->
            <div class="col-md-6 col-12 pt-3 pt-md-0">
                <h4>{{product.productName}}</h4>

                <h6 class="category font-italic" id="bottom-space">{{category.categoryName}}</h6>

                <p id="bottom-space"><span class="font-weight-bold">Description: -</span> <br>{{product.description}}</p>

                <div class="d-flex flex-row justify-content-between">
                    <div class="input-group col-md-3 col-4 p-0">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">Quantity</span>
                        </div>
                        <input class="form-control" type="number" v-model="quantity"/>
                    </div>
                 <!-- Add to cart button-->
                 <button type="button" id="add-to-cart-button" class="btn" @click="addToCart(this.id)">
                        Add to Cart
                        <ion-icon name="cart-outline" v-pre></ion-icon>
                    </button>
                </div>
            </div>
        </div>
        <div class="column pt-5">
                <div class="features pt-3">
                    <h5><strong>Reviews</strong></h5>
                    <ul v-for= "review of reviews" :key="review.id" class="reviewslist">
                        <li class="reviewItem">{{review.review}} - {{review.userName}}</li>
                    </ul>
                </div>
                <div id="add-Review">
                    <h5><strong>Add Your Reviews</strong></h5>
                    <form>
                        <label> Review: </label>
                        <textarea v-model="content"></textarea>
                    </form>
                    <button type="button" id="add-review-button" class="btn" @click="addReview(this.id, content )">
                        Add a Review
                    </button>
                </div>
            
        </div>

    </div>

</template>

<script>
const axios = require('axios')
import swal from 'sweetalert';
    export default {
      data(){
          return {
              product : {},
              category : {},
              id : null,
              quantity: 1,
              reviews: null,
              content:null
          }
      },
      props : ["baseURL","products", "categories"],
      methods:{ // add to cart function
        addToCart(productId){
            // post productId and quantity
            axios.post(`${this.baseURL}shoppingcart/add?UserName=${this.userName}`,{
                productId : productId,
                quantity : this.quantity
            }).then((response) => {
                // success
                if(response.status==201){
                    swal({
                        text: "Product Added to the cart!",
                        icon: "success",
                        closeOnClickOutside: false,
                    });
                }
            },(error) =>{
                // error handling
                console.log(error)
                if(this.userName==null){
                        swal({
                        text: "Please Login to add the product to cart",
                        icon: "error",
                        closeOnClickOutside: false,
                    });
                }
                else{
                    swal({
                        text: "Something wrong with add to cart",
                        icon: "error",
                        closeOnClickOutside: false,
                    });
                }
            });
        },
        addReview(productId, rev){
            // post productId and quantity
            axios.post(`${this.baseURL}review/add`,{
                productId : productId,
                review : rev,
                userName: this.userName
            }).then((response) => {
                // success
                if(response.status==201){
                    swal({
                        text: "Review Added!",
                        icon: "success",
                        closeOnClickOutside: false,
                    });
                    this.getReviews(productId)
                    this.content = null
                }
            },(error) =>{
                // error handling
                console.log(error)
                swal({
                    text: "Something wrong with add a Review",
                    icon: "error",
                    closeOnClickOutside: false,
                });
            });
        },
        getReviews(productId){
            axios.get(`${this.baseURL}/review/?productId=${productId}`).then((response) => {
                if(response.status==200){
                const result = response.data;
                // store cartitems and total price in two variables
                this.reviews = result;
                }
            },
            (error)=>{
                console.log(error)
            });
        },

      },
      mounted() {
          this.id = this.$route.params.id;
          this.product = this.products.find(product => product.productId == this.id);
          this.category = this.categories.find(category => category.id == this.product.categoryId);
          this.userName = localStorage.getItem('userName');
          this.getReviews(this.id)
      }
    }
</script>

<style>
    .category {
        font-weight: 400;
    }

    /* Chrome, Safari, Edge, Opera */
    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }

    #add-to-cart-button {
    background-color: #febd69;
    }

    .reviewslist{
        text-align: initial;
    }

    #add-Review{
        box-sizing: border-box;
        text-align: initial;
        margin-top: 50px;
    }

    label{
        display: block;
    }

    input[type="text"],textarea{
        display: block;
        width: 100%;
        padding: 8px
    }

    #add-review-button{
        background-color: #febd69;
        margin: 20px auto;
    }

    #bottom-space{
        margin-bottom: 3rem;
    }

    li{
        padding-bottom: 0px !important;
    }

</style>
