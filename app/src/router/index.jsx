import { createBrowserRouter } from "react-router-dom";
import { 
  StartScreen,
  LoginScreen,
  MenuScreen,
  CampaignScreen,
  CategoryScreen,
  ContentListScreen,
  NotFoundScreen,
  ContentDetailsScreen,
  RegisterScreen, } from "../ui/screens";
import { PrivateRouteUsuario } from "./private-route-usuario.component"

export const router = createBrowserRouter([
  {
    path: "*",
    element: <NotFoundScreen />,
  },
  {
    path: "/",
    element: <StartScreen />,
  },
  {
    path: "/register",
    element: <RegisterScreen />,
  },
  {
    path: "/login",
    element: <LoginScreen />,
  },
  {
    path: "/menu",
    element: <PrivateRouteUsuario Screen={MenuScreen} />,
  },
  {
    path: "/library/campaign",
    element: <PrivateRouteUsuario Screen={CampaignScreen} />,
  },
  {
    path: "/library/:campaignId/category",
    element: <PrivateRouteUsuario Screen={CategoryScreen} />,
  },
  {
    path: "/library/:campaignId/category/:categoryId",
    element: <PrivateRouteUsuario Screen={ContentListScreen} />,
  },
  {
    path: "/library/content/:contentId",
    element: <PrivateRouteUsuario Screen={ContentDetailsScreen} />,
  },
]);
