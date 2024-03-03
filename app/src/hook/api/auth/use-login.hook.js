import { axiosInstance } from "../../base/axios-instance.api";
import { useNavigate } from "react-router-dom";
import useGlobalUser from "../../../context/global-user.context"
import { useToast } from "../../toast/use-toast.hook";
import { useSound } from "../../sound/use-sound.hook";

export function useLogin() {
  const [,setGlobalUser] = useGlobalUser();
  const { playLogin, playWrong } = useSound();
  const { toastError } = useToast();

  async function _login({ email, password }) {
    const response = await axiosInstance.post(
      "/login",
      {},
      {
        auth: {
          username: email,
          password,
        },
      }
    );
    return response.data;
  }

  async function login({ email, password }) {
    try {
      const user = await _login({ email, password })
      setGlobalUser(user.id)
      playLogin()
      return true
    } catch (error) {
      toastError(error)
      playWrong()
      return false
    }
  }

  return { login };
}
