<template>
  <a-modal v-model:visible="visible"
           modal-class="modal-form-large"
           title-align="start"
           :title="title"
           :top="80"
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
              :auto-label-width="true"
              :rules="formRules">
        <!-- 角色名称 -->
        <a-form-item field="name" label="角色名称">
          <a-input v-model="formModel.name"
                   placeholder="请输入角色名称"
                   allow-clear />
        </a-form-item>
        <!-- 角色编码 -->
        <a-form-item field="code" label="角色编码">
          <a-input v-model="formModel.code"
                   :disabled="!isAddHandle"
                   placeholder="请输入角色编码"
                   allow-clear />
        </a-form-item>
        <!-- 角色描述 -->
        <a-form-item field="description" label="角色描述">
          <a-textarea v-model="formModel.description"
                      placeholder="请输入角色描述"
                      allow-clear />
        </a-form-item>
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script lang="ts">
  export default {
    name: 'roleFormModal'
  };
</script>

<script lang="ts" setup>
  import type { RoleUpdateRequest } from '@/api/user/role';
  import { ref } from 'vue';
  import useLoading from '@/hooks/loading';
  import useVisible from '@/hooks/visible';
  import formRules from '../types/form.rules';
  import { createRole, updateRole } from '@/api/user/role';
  import { Message } from '@arco-design/web-vue';

  const { visible, setVisible } = useVisible();
  const { loading, setLoading } = useLoading();

  const title = ref<string>();
  const isAddHandle = ref<boolean>(true);

  const defaultForm = (): RoleUpdateRequest => {
    return {
      id: undefined,
      name: undefined,
      code: undefined,
      description: undefined,
    };
  };

  const formRef = ref();
  const formModel = ref<RoleUpdateRequest>({});

  const emits = defineEmits(['added', 'updated']);

  // 打开新增
  const openAdd = () => {
    title.value = '添加角色';
    isAddHandle.value = true;
    renderForm({ ...defaultForm() });
    setVisible(true);
  };

  // 打开修改
  const openUpdate = (record: any) => {
    title.value = '修改角色';
    isAddHandle.value = false;
    renderForm({ ...defaultForm(), ...record });
    setVisible(true);
  };

  // 渲染表单
  const renderForm = (record: any) => {
    formModel.value = Object.assign({}, record);
  };

  defineExpose({ openAdd, openUpdate });

  // 确定
  const handlerOk = async () => {
    setLoading(true);
    try {
      // 验证参数
      const error = await formRef.value.validate();
      if (error) {
        return false;
      }
      if (isAddHandle.value) {
        // 新增
        await createRole(formModel.value);
        Message.success('创建成功');
        emits('added');
      } else {
        // 修改
        await updateRole(formModel.value);
        Message.success('修改成功');
        emits('updated');
      }
      // 清空
      handlerClear();
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
