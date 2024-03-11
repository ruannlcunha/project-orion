import { axiosInstance } from "../../base/axios-instance.api";
import { useNavigate } from "react-router-dom";
import { useToast } from "../../toast/use-toast.hook";

export function useCadastro() {
  const navigate = useNavigate()
  const { toastSuccess, toastWarning } = useToast();

  async function _cadastro({ nome, email, senha, confirmacaoDeSenha }) {
    await axiosInstance.post(
      "/usuarios",
      {
        nome,
        email,
        senha,
        confirmacaoDeSenha
      }
    );
  }

  async function cadastro({ nome, email, senha, confirmacaoDeSenha }) {
    try {
      await _cadastro({ nome, email, senha, confirmacaoDeSenha })
      navigate("/login")
      toastSuccess("Cadastrado com sucesso!")
    } catch (error) {
      toastWarning(error)
    }
  }

  return { cadastro };
}
