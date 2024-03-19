import { ButtonPrimary, ContainerScreen, Input, BackButton } from "../../components"
import "./login.style.css"
import whiteScreen from "../../../assets/image/white_screen.png"
import orion from "../../../assets/image/orion_1.png"
import { useNavigate } from "react-router-dom";
import { useForm, useLogin } from "../../../hook";
import { THEME_TYPES } from "../../../constants";
import { useState } from "react";

export function LoginScreen() {
    const navigate = useNavigate();
    const [submited, setSubmited] = useState(false);
    const { login } = useLogin()
    const {formData, handleChange} = useForm({
        email: "",
        password: ""});
    
    async function handleSubmit(event) {
        event.preventDefault()
        const loginSuccessful = await login({
            email: formData.email,
            password: formData.password
        })
        
        if(loginSuccessful) {
            setSubmited(true)
            setTimeout(()=>{navigate("/menu")}, 4000 )
        }
    }

    return (
        <ContainerScreen>
            <div className={"login-fundo"}> 
            <BackButton theme={THEME_TYPES.LIGHT_THEME}/>
                <img src={orion} alt="Logo do RollShare" />
                <section>
                    <h1>Login</h1>
                    <form onSubmit={handleSubmit}>
                        <Input 
                        label={"Email"}
                        name={"email"}
                        value={formData.email}
                        type={"text"}
                        onChange={handleChange}
                        placeholder={"Digite seu email."}
                        />
                        <Input 
                        label={"Senha"}
                        name={"password"}
                        value={formData.password}
                        type={"password"}
                        onChange={handleChange}
                        placeholder={"Digite sua senha."}
                        />
                        <label>Não tem cadastro? <span onClick={()=>navigate("/register")}>Clique aqui</span>
                        </label>
                        <ButtonPrimary>Entrar</ButtonPrimary>
                    </form>
                </section>
            {submited? <img src={whiteScreen} alt="Tela Branca" className="white-screen" /> : null}
            </div>
        </ContainerScreen>
    )

}