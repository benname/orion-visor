<template>
  <a-modal v-model:visible="visible"
           modal-class="modal-form-large"
           title-align="start"
           title="修改密码"
           :top="120"
           :align-center="false"
           :draggable="true"
           :mask-closable="false"
           :unmount-on-close="true"
           :ok-button-props="{ disabled: loading }"
           :cancel-button-props="{ disabled: loading }"
           :on-before-ok="handlerOk"
           @close="handleClose">
    <a-spin class="full" :loading="loading">
      <a-form :model="formModel"
              ref="formRef"
              label-align="right"
              :rules="rules">
        <!-- 原始密码 -->
        <a-form-item field="beforePassword"
                     label="原始密码"
                     hide-label>
          <a-input-password v-model="formModel.beforePassword" placeholder="请输入原始密码" />
        </a-form-item>
        <!-- 新密码 -->
        <a-form-item field="password"
                     label="新密码"
                     hide-label>
          <a-input-password v-model="formModel.password" placeholder="请输入新密码" />
        </a-form-item>
        <!-- 确认密码 -->
        <a-form-item field="checkPassword"
                     label="确认密码"
                     hide-label>
          <a-input-password v-model="formModel.checkPassword" placeholder="请再次输入新密码" />
        </a-form-item>
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script lang="ts">
  export default {
    name: 'updatePasswordModal'
  };
</script>

<script lang="ts" setup>
  import type { FieldRule } from '@arco-design/web-vue';
  import type { UserUpdatePasswordRequest } from '@/api/user/mine';
  import { ref } from 'vue';
  import { md5 } from '@/utils';
  import useLoading from '@/hooks/loading';
  import useVisible from '@/hooks/visible';
  import { Message } from '@arco-design/web-vue';
  import { updateCurrentUserPassword } from '@/api/user/mine';

  const emits = defineEmits(['updated']);

  const { visible, setVisible } = useVisible();
  const { loading, setLoading } = useLoading();

  const rules = {
    beforePassword: [{
      required: true,
      message: '请输入原始密码'
    }],
    password: [{
      required: true,
      message: '请输入新密码'
    }, {
      minLength: 8,
      maxLength: 32,
      message: '新密码长度需要在 8-32 位之间'
    }, {
      validator: (value, cb) => {
        if (formModel.value.beforePassword === value) {
          cb('新密码不能和原始密码相同');
          return;
        }
      }
    }],
    checkPassword: [{
      required: true,
      message: '请再次输入新密码'
    }, {
      validator: (value, cb) => {
        if (formModel.value.password !== value) {
          cb('两次输入的密码不一致');
          return;
        }
      }
    }],
  } as Record<string, FieldRule | FieldRule[]>;

  const formRef = ref();
  const formModel = ref<UserUpdatePasswordRequest>({});

  // 打开
  const open = () => {
    formModel.value = {
      beforePassword: undefined,
      password: undefined,
      checkPassword: undefined,
    };
    setVisible(true);
  };

  defineExpose({ open });

  // 确定
  const handlerOk = async () => {
    setLoading(true);
    try {
      // 验证参数
      const error = await formRef.value.validate();
      if (error) {
        return false;
      }
      // 修改
      await updateCurrentUserPassword({
        beforePassword: md5(formModel.value.beforePassword as string),
        password: md5(formModel.value.password as string)
      });
      Message.success('修改成功');
      // 清空
      handlerClear();
      emits('updated');
    } catch (e) {
      return false;
    } finally {
      setLoading(false);
    }
  };

  // 关闭
  const handleClose = () => {
    handlerClear();
  };

  // 清空
  const handlerClear = () => {
    setLoading(false);
  };

</script>

<style lang="less" scoped>

</style>
