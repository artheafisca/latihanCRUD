<template>
    <div>
        <router-link to="/" class="btn btn-primary mt-3 ml-3" v-show="!success">Back</router-link>
        <div class="container">
            <div class="row justify-content-center my-5">
                <div class="col-10 p-5 border border-primary">
                    <form @submit.prevent="submitData" v-show="!success" >
                        <center>
                        <h2 class="mb-5"> {{titleValue}} </h2>
                        </center>
                        <div class="form-row">
                            <div class="form-group col-md-6" >
                                <label>Student Name</label>
                                <input 
                                    v-model="studentData.nama"
                                    type="text" 
                                    class="form-control" 
                                    placeholder="Enter name" 
                                    required>
                            </div>  
                            <div class="form-group col-md-6">
                                <label>Soft Skills</label>
                                <input 
                                    v-model="studentData.soft_skill"
                                    type="text" 
                                    class="form-control" 
                                    placeholder="Enter soft skills" 
                                    required>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-3">
                                <label>Student Age</label>    
                                <input 
                                    v-model="studentData.umur"
                                    type="text" 
                                    class="form-control"  
                                    placeholder="Enter age" 
                                    required>
                            </div>
                            <div class="form-group col-3">
                                <label>Gender</label>    
                                <select 
                                    class="form-control"
                                    v-model="studentData.jenis_kelamin"
                                    required>
                                    <option readonly></option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label>Hard Skills</label>
                                <input 
                                    v-model="studentData.hard_skill"
                                    type="text" 
                                    class="form-control" 
                                    placeholder="Enter hard skills">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                            <label>Student Email</label>
                            <input 
                                v-model="studentData.email"
                                type="email" 
                                class="form-control"  
                                placeholder="Enter email">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Interest</label>
                                <select 
                                    class="form-control"
                                    v-model="studentData.interest"
                                    required>
                                    <option readonly></option>
                                    <option value="Data Science">Data Science</option>
                                    <option value="Network">Network</option>
                                    <option value="Web Frontend">Web Frontend</option>
                                    <option value="Web Backend">Web Backend</option>
                                    <option value="Mobile Apps">Mobile Apps</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label>Self Desciption</label>
                            <textarea 
                                v-model="studentData.deskripsi_diri"
                                class="form-control" 
                                rows="3" 
                                required></textarea>
                        </div>
                        <button 
                        type="submit" 
                        class="btn btn-primary">
                            {{buttonValue}}
                        </button>
                    </form>
                    <SuccessForm v-show="success"></SuccessForm>
                </div>
            </div>
      </div>
    </div>
</template>

<script>
import studentService from "../services/studentService";
import SuccessForm from './SuccessForm.vue';

export default {
    components: { SuccessForm },
    name: "FormComponent",
    data() {
        return{
            studentData: {
                "deskripsi_diri"    : null,
                "email"             : null,
                "hard_skill"        : null,
                "interest"          : null,
                "jenis_kelamin"     : null,
                "nama"              : null,
                "soft_skill"        : null,
                "umur"              : null 
            },
            buttonValue: "Submit",
            titleValue: "Add Student",
            success: false
        }
    },
    methods: {
        submitData(){
            let data = this.studentData;
            
            if(this.buttonValue === "Submit") {
                studentService.insert(data)
                    .then(response => {
                        console.log(response.data);
                        this.success = true;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            } else {
                studentService.updateStudent(data.id, data)
                .then(response => {
                    this.studentData = response.data;
                    console.log(this.studentData);
                    this.success = true;
                })
                .catch(e => {
                    console.log(e);
                })
            }
        }
    },
    props: ["updateStudentProps"],
    watch: {
        'updateStudentProps'(newValue) {
            this.studentData = newValue;
            console.log(this.studentData);
            this.buttonValue = "Update";
            this.titleValue = "Update Student";
        }
    },
}
</script>

<style>

</style>