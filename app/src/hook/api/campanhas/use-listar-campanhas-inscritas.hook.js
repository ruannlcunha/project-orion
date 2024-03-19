import { useState } from "react";
import { axiosInstance } from "../../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useListarCampanhasInscritas() {
    const [campanhasInscritas, setCampanhasInscritas] = useState([])
    const [isLoading, setIsLoading] = useState(true)
    const { toastError } = useToast();

    async function _listarCampanhasInscritas(page) {
        const response = await axiosInstance.get(
        `/campanhas/inscritas?page=${page}&sort=desc`,
        );
        return response.data;
    }

    async function listarCampanhasInscritas(page) {
        try {
            const _campanhasInscritas = await _listarCampanhasInscritas(page)
            setCampanhasInscritas(_campanhasInscritas)
        } catch (error) {
            toastError(error)
        }
        finally{
            setIsLoading(false)
        }
    }

    return { campanhasInscritas, isLoading, setCampanhasInscritas, listarCampanhasInscritas };
}
