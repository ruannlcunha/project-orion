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
    element: <MenuScreen />,
  },
  {
    path: "/library/campaign",
    element: <CampaignScreen />,
  },
  {
    path: "/library/:campaignId/category",
    element: <CategoryScreen />,
  },
  {
    path: "/library/:campaignId/category/:categoryId",
    element: <ContentListScreen />,
  },
  {
    path: "/library/content/:contentId",
    element: <ContentDetailsScreen />,
  },
]);
