import { axiosInstance } from "../../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useInscreverCampanha() {
  const { toastWarning } = useToast();

  async function _inscreverCampanha(campaignId) {
    await axiosInstance.post(
      `/campanhas/inscrever/${campaignId}`
    );
  }

  async function inscreverCampanha(campaignId, callback) {
    try {
      await _inscreverCampanha(campaignId)
      callback()
    } catch (error) {
      toastWarning(error)
    }
  }

  return { inscreverCampanha };
}
