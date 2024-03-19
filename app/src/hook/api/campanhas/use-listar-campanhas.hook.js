import { useState } from "react";
import { axiosInstance } from "../../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useListarCampanhas() {
    const [campanhas, setCampanhas] = useState([])
    const [isLoading, setIsLoading] = useState(true)
    const { toastError } = useToast();

    async function _listarCampanhas(page) {
        const response = await axiosInstance.get(
        `/campanhas?page=${page}&sort=desc`,
        );
        return response.data;
    }

    async function listarCampanhas(page) {
        try {
            const _campanhas = await _listarCampanhas(page)
            setCampanhas(_campanhas)
        } catch (error) {
            toastError(error)
        }
        finally{
            setIsLoading(false)
        }
    }

    return { campanhas, isLoading, setCampanhas, listarCampanhas };
}
