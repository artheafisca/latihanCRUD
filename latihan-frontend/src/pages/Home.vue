<template>
  <div>
    <Header></Header>
    <Card ></Card>
    <Copyright></Copyright>
  </div>
  
</template>

<script>
import Header from '@/components/Header.vue'
import Card from '@/components/Card.vue'
import Copyright from '@/components/Copyright.vue'

export default {
    name: 'HomePage',
    components: {
        Header,
        Card,
        Copyright,
    },
    
}
</script>

<style>

</style>