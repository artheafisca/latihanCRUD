<template>
  <div>
    <Header></Header>
    <Form :updateStudentProps= "studentData" ></Form>
    <Copyright></Copyright>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Form from '@/components/Form.vue'
import Copyright from '@/components/Copyright.vue'
import studentService from '@/services/studentService'
export default {
    name: "updatePage",
    components: { Header, Form, Copyright },
    methods: {
      updateData(){
        let id = this.$route.params.id;

        studentService.updateGetId(id)
        .then(Response => {
            this.studentData = Response.data;
            console.log(Response.data);
        })
        .catch(e => {
            console.log(e);
        })
      }
    },
    mounted(){
        this.updateData(); 
    },
    data(){
      return {
        studentData: null,
      }
    }

}
</script>

<style>

</style>