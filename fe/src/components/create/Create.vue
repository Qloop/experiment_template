<template>
  <div class="create-container">
    <top-nav activeIndex="1"></top-nav>
    <div class="form-area">
      <div class="title">
        <h1>实验报告生成系统</h1>
        <p>请在此处创建实验报告模板，请先仔细阅读要求。在文本中插入让学生填写的空请按如下方法插入，以" {{question0<span>}}"</span>的形式留空，必须是question打头，后跟一数字，从0开始数。例如：本次实验的目的是{{question0<span>}}</span>，通过{{question1<span>}}</span>方法，得到{{question3<span>}}结果。</span></p>
      </div>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="实验标题">
          <el-input v-model="form.title"></el-input>
        </el-form-item>
        <el-form-item label="实验目的">
          <el-input type="textarea" v-model="form.goal"></el-input>
        </el-form-item>
        <el-form-item label="实验原理">
          <el-input type="textarea" v-model="form.theory"></el-input>
        </el-form-item>
        <el-form-item label="实验器材">
          <el-input type="textarea" v-model="form.equipment"></el-input>
        </el-form-item>
        <el-form-item label="实验要求">
          <el-input type="textarea" v-model="form.demand"></el-input>
        </el-form-item>
        <el-form-item label="注意事项">
          <el-input type="textarea" v-model="form.warning"></el-input>
        </el-form-item>
        <el-form-item label="实验数据记录和处理">
          <el-input type="textarea" v-model="form.data"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import API from '../../config/request';
  import TopNav from '../common/TopNav.vue';
  export default {
    data() {
      return {
        form: {
          title: '',
          goal: '',
          theory: '',
          equipment: '',
          demand: '',
          warning: '',
          data: '',
          thinking: ''
        }
      }
    },
    methods: {
      onSubmit() {
//        let postData = JSON.stringify(this.form);
        let postData = this.form;
        console.log(postData);
        this.$http.post(API.create, postData).then(
          (res) => {
            console.log(res);
          }
        )
      }
    },
    components: {
      TopNav
    }
  }
</script>

<style lang="less" scoped>
  .create-container {

    .form-area {
      margin: 40px 15%;

      .title {
        margin: 30px;

        h1 {
          text-align: center;
        }
      }
    }
  }
</style>
