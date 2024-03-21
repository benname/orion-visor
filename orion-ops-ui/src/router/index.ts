import type { RouteLocationRaw } from 'vue-router';
import { createRouter, createWebHistory } from 'vue-router';
import NProgress from 'nprogress';
import { appRoutes } from './routes';
import BASE_ROUTERS from './routes/base';
import createRouteGuard from './guard';
import { openWindow } from '@/utils';
import 'nprogress/nprogress.css';

NProgress.configure({ showSpinner: false });

// 创建路由
const router = createRouter({
  history: createWebHistory(),
  routes: [
    ...BASE_ROUTERS,
    ...appRoutes,
  ],
  scrollBehavior() {
    return { top: 0 };
  },
});

// 创建路由守卫
createRouteGuard(router);

// 新页面打开路由
export const openNewRoute = (route: RouteLocationRaw) => {
  const { href } = router.resolve(route);
  openWindow(href);
};

export default router;
