import { useState } from "react";
import { axiosInstance } from "../../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useListarCategorias() {
    const [categorias, setCategorias] = useState([])
    const [isLoading, setIsLoading] = useState(true)
    const { toastError } = useToast();

    async function _listarCategorias(campaignId) {
        const response = await axiosInstance.get(
        `/categorias/${campaignId}`,
        );
        return response.data;
    }

    async function listarCategorias(campaignId) {
        try {
            const _categorias = await _listarCategorias(campaignId)
            setCategorias(_categorias)
        } catch (error) {
            toastError(error)
        }
        finally{
            setIsLoading(false)
        }
    }

    return { categorias, isLoading, setCategorias, listarCategorias };
}
