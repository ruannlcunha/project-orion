import "./loading.style.css"
import loadingImg from "../../../assets/image/loading.gif"

export function Loading({isLoading}) {

    return (
        <>
        {isLoading?
        <div className="loading">
            <img src={loadingImg} alt="Círculo de carregamento rodando" />
        </div>
        :null}
        </>
    )

}