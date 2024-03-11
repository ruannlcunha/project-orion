import { useState } from "react";
import { axiosInstance } from "../../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useListarConteudos() {
    const [conteudos, setConteudos] = useState([])
    const { toastError } = useToast();

    async function _listarConteudos(filter, categoryId) {
        const response = await axiosInstance.get(
        `/conteudos?filtro=${filter}&categoria=${categoryId}`,
        );
        return response.data;
    }

    async function listarConteudos(filter, categoryId) {
        try {
            const _conteudos = await _listarConteudos(filter, categoryId)
            setConteudos(_conteudos)
        } catch (error) {
            toastError(error)
        }
    }

    return { conteudos, setConteudos, listarConteudos };
}
