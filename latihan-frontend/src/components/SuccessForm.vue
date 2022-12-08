<template>
    <div class="card-body text-center">
        <h5 class="card-title">Success!</h5>
        <p class="card-text">Student data has been {{textValue}}!</p>
        <router-link to="/" class="btn btn-sm btn-primary">Close</router-link>
    </div>
</template>

<script>
export default {
    name: "successFormComponent",
    data(){
        return {
            textValue: null,
            currentPath: null
        }
    },
    mounted() {
        this.currentPath = this.$route.path;
        this.textAlert();
    },
    methods: {
        textAlert() {
            if (this.currentPath == "/add") {
                this.textValue = "inputed";
            } else {
                this.textValue = "updated";
            }
        }
    }
}
</script>

<style>

</style>