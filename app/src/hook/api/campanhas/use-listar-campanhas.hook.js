import { useState } from "react";
import { axiosInstance } from "../../base/axios-instance.api";
import { useToast } from "../../toast/use-toast.hook";

export function useListarCampanhas() {
    const [campanhas, setCampanhas] = useState([])
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
    }

    return { campanhas, setCampanhas, listarCampanhas };
}
