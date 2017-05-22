/**
 * Created by lhy95 on 2017/5/21.
 */

import Vue from 'vue'

export default {
  props: {
    text: {
      type: String
    },
    componentId: {
      type: String
    },
    questionNumber: {
      type: Number
    }
  },
  watch: {
    text(val, oldVal) {
      this.compile();
    }
  },
  render(h) {
    return (
      <div id={this.componentId}>
      </div>
    )
  },
  methods: {
    compile() {
      let self = this;
      let data = {};
      let inputFormString = '';
      for (let i = 0; i < this.questionNumber; i++) {
        let key = 'question'+i;
        data[key] = ' 问题' + i + ' ';
        inputFormString += `<input v-model="${key}">`
      }
      let tempComponent = new Vue({
        template: `
          <div class="form-container" id="${this.componentId}">
            <p>${self.text}</p>
            <div class="input-area">
              ${inputFormString}
            </div>
          </div>
        `,
        parent: this,
        data: data
      }).$mount('#' + self.componentId);
    }
  }
}
