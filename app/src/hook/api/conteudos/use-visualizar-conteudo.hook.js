import { useState } from "react";
import { axiosInstance } from "../../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useVisualizarConteudo() {
    const [conteudo, setConteudo] = useState({})
    const { toastError } = useToast();

    async function _visualizarConteudo(contentId) {
        const response = await axiosInstance.get(
        `/conteudos/${contentId}`,
        );
        return response.data;
    }

    async function visualizarConteudo(contentId) {
        try {
            const _conteudo = await _visualizarConteudo(contentId)
            setConteudo(_conteudo)
        } catch (error) {
            toastError(error)
        }
    }

    return { conteudo, setConteudo, visualizarConteudo };
}
