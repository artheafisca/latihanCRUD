<template>
    <div>
        <router-link to="/add" class="btn btn-primary mt-3 ml-3" v-show="!success">Add Data</router-link>
        <div class="row px-3 mt-3" >
                <div class="col-sm-4 mt-3" v-for="item in studentData" :key="item.id" v-show="!success"  >
                    <div class="card border-primary border-rounded" >
                        <div class="card-body" >
                            <h6 class="card-title"> {{item.nama + ", " + item.umur + " " + "years old" }} </h6>
                            <p class="card-text"> {{item.deskripsi_diri}} </p>
                            <table class="border-none">
                                <tr>
                                    <td>Email</td>
                                    <td>:</td>
                                    <td> {{item.email }} </td>
                                </tr>
                                <tr>
                                    <td>Soft Skills</td>
                                    <td>:</td>
                                    <td> {{item.soft_skill}} </td>
                                </tr>
                                <tr>
                                    <td>Hard Skills</td>
                                    <td>:</td>
                                    <td> {{item.hard_skill}} </td>
                                </tr>
                                <tr>
                                    <td>Interest</td>
                                    <td>:</td>
                                    <td> {{item.interest}} </td>
                                </tr>
                            </table>
                            <div class=" d-flex mt-2">
                                <router-link
                                    :to="'/update/' + item.id"
                                    class="btn btn-sm btn-primary">
                                    Update
                                </router-link>

                                <button 
                                    @click="deleteStudentFunc(item.id)"
                                    class="btn btn-sm btn-danger ml-2">
                                    Delete
                                </button>

                                <img 
                                    v-if="item.jenis_kelamin == 'Female'"
                                    src="../assets/img/female.png" 
                                    style="min-width: 2vw; height: 5vh;" 
                                    class="ml-auto">
                                <img 
                                    v-else
                                    src="../assets/img/male.png"
                                    style="min-width: 2vw; height: 5vh;" 
                                    class="ml-auto">
                            </div>
                        </div>
                    </div>
                </div>
                <SuccessDelete class="col-sm-6  m-auto my-5" v-show="success"></SuccessDelete>
        </div>
    </div>
</template>

<script>
import studentService from "../services/studentService";
import SuccessDelete from './SuccessDelete.vue';

export default {
    components: {SuccessDelete },
    name: "CardComponent",
    data() {
        return {
            studentData: null,
            success: false
        }
    },
    methods: {
        getStudent(){
            studentService.getAll()
                .then(response => {
                    this.studentData = response.data;
                    console.log(this.studentData);
                })
                .catch(e => {
                    console.log(e);
                });
        },
        deleteStudentFunc(id){
            if(confirm("Are you sure want to delete?")){
                studentService.deleteStudent(id)
                .then(response => {
                    console.log(response.data);
                    this.success = true;
                })
                .catch(e => {
                    console.log(e);
                });
                // location.reload();
            }else {
                alert("Your data is safe!")
            }
        }
    },
    mounted(){
        this.getStudent();
    }
}
</script>

<style>

</style>