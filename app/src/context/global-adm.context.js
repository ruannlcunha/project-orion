import createGlobalState from "react-create-global-state";

const stateInStorage = localStorage.getItem("adm");
const initialState = stateInStorage ? JSON.parse(stateInStorage) : null;

const [_useGlobalAdm, Provider] = createGlobalState(initialState);

function useGlobalAdm() {
  const [_adm, _setAdm] = _useGlobalAdm();

  function setAdm(adm) {
    _setAdm(adm);
    localStorage.setItem("adm", JSON.stringify(adm));
  }

  return [_adm, setAdm];
}

export const GlobalAdmProvider = Provider;
export default useGlobalAdm;
