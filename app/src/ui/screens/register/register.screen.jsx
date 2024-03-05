import { useCadastro, useForm } from "../../../hook";
import { ContainerScreen, BackButton, ButtonPrimary, Input } from "../../components"
import "./register.style.css"
import { THEME_TYPES } from "../../../constants";

export function RegisterScreen() {
    const { cadastro } = useCadastro();
    const {formData, handleChange} = useForm({
        name: "",
        email: "",
        password: "",
        confirmPassword: ""});
    
    function handleSubmit(event) {
        event.preventDefault()
        cadastro({
            nome: formData.name,
            email: formData.email,
            senha: formData.password,
            confirmacaoDeSenha: formData.confirmPassword
        })
    }

    return (
        <ContainerScreen>
            <div className={"register-screen"}> 
            <BackButton theme={THEME_TYPES.DARK_THEME}/>
                <section>
                    <h1>Cadastro</h1>
                    <form onSubmit={handleSubmit}>
                        <Input 
                        label={"Nome"}
                        name={"name"}
                        value={formData.name}
                        type={"text"}
                        onChange={handleChange}
                        placeholder={"Digite seu nome."}
                        />
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
                        <Input 
                        label={"Confirmar Senha"}
                        name={"confirmPassword"}
                        value={formData.confirmPassword}
                        type={"password"}
                        onChange={handleChange}
                        placeholder={"Confirme sua senha."}
                        />
                        <ButtonPrimary>Entrar</ButtonPrimary>
                    </form>
                </section>
            </div>
        </ContainerScreen>
    )
}