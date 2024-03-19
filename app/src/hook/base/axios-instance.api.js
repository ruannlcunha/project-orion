import axios from "axios";

export const axiosInstance = axios.create({
  baseURL: "https://vq6v34kn-8080.brs.devtunnels.ms/",
  withCredentials: true
});
