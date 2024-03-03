import { ButtonPrimary, ContainerScreen, Input, BackButton } from "../../components"
import "./login.style.css"
import orion from "../../../assets/image/orion_1.png"
import { useNavigate } from "react-router-dom";
import whiteScreen from "../../../assets/image/white_screen.png"
import { useForm, useSound } from "../../../hook";
import { useState } from "react";

export function LoginScreen() {
    const navigate = useNavigate();
    const [submited, setSubmited] = useState(false);
    const { playLogin } = useSound();
    const {formData, handleChange} = useForm({
        email: {value: "", error: ""},
        senha: {value: "", error: ""}});
    
    function handleSubmit(event) {
        event.preventDefault()
        playLogin()
        setSubmited(true)
        setTimeout(()=>{navigate("/menu")}, 4000 )
    }

    return (
        <ContainerScreen>
            <div className={"login-fundo"}> 
            <BackButton />
                <img src={orion} alt="Logo do RollShare" />
                <section>
                    <h1>Login</h1>
                    <form onSubmit={handleSubmit}>
                        <Input 
                        label={"Email"}
                        name={"email"}
                        value={formData.email.value}
                        type={"text"}
                        onChange={handleChange}
                        placeholder={"Digite seu email."}
                        />
                        <Input 
                        label={"Senha"}
                        name={"senha"}
                        value={formData.senha.value}
                        type={"password"}
                        onChange={handleChange}
                        placeholder={"Digite sua senha."}
                        />
                        <ButtonPrimary>Entrar</ButtonPrimary>
                    </form>
                </section>
            {submited? <img src={whiteScreen} alt="Tela Branca" className="white-screen" /> : null}
            </div>
        </ContainerScreen>
    )

}