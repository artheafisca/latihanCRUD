<template>
  <div>
    <router-link to="/add" class="btn btn-primary mt-3 ml-3">Add Data</router-link>
  </div>
</template>

<script>
export default {
    name: "ButtonAddComponent",
    data(){
      return{
        BtnAddValue: "Add Data"
      }
    }
}
</script>

<style>

</style>