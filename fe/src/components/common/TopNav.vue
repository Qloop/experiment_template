<template>
  <div>
    <el-menu theme="dark" :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item index="1">创建实验报告</el-menu-item>
      <el-menu-item index="2">查看实验报告</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
  export default {
    props: {
      activeIndex: {
        type: String,
        default: '1'
      }
    },
    methods: {
      handleSelect(select) {
//        console.log(select)
        switch (select) {
          case '1':
            this.$router.push('/create');
            break;
          case '2':
            this.$router.push('/display');
            break;
        }
      }
    }
  }
</script>

<style>

</style>
