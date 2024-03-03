import { axiosInstance } from "../../base/axios-instance.api";
import { useNavigate } from "react-router-dom";
import { useToast } from "../../toast/use-toast.hook";
import useGlobalUser from "../../../context/global-user.context"
import { useSound } from "../../sound/use-sound.hook";

export function useLogout() {
  const navigate = useNavigate();
  const [,setGlobalUser] = useGlobalUser();
  const { toastSuccess, toastError } = useToast();
  const { playClick } = useSound();

  async function _logout() {
    await axiosInstance.post("/logout");
  }

  async function logout() {
    try {
      playClick()
      await _logout()
      toastSuccess("Tchau! Até logo!")
      setGlobalUser(null)
      navigate("/")
    } catch (error) {
      toastError(error)
    }
  }

  return { logout };
}
