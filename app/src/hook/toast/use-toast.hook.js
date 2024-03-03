import { toast } from 'react-toastify';
import useGlobalUser from "../../context/global-user.context";
import useGlobalAdm from "../../context/global-adm.context"

export function useToast() {
    const [,setUser] = useGlobalUser();
    const [,setGlobalAdm] = useGlobalAdm();

    function toastSuccess(message) {
        toast.success(message , {
            position: "top-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "dark",
            });
    }

    function toastWarning(error) {
        let errorMessage = error;
        if(error.response) errorMessage = error.response.data.message;

        toast.warn(errorMessage , {
            position: "top-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "dark",
            });
    }

    function toastError(error) {
        if(error.response.data) {
            toast.error(error.response.data.message , {
                position: "top-right",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "dark",
                });

            return 
        }
        else {
            toast.error("Ocorreu um erro." , {
                position: "top-right",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "dark",
                });
            setUser(null)
            setGlobalAdm(null)
        }
        
    }


    return { toastSuccess, toastWarning, toastError }

}