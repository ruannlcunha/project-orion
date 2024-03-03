import createGlobalState from "react-create-global-state";

const stateInStorage = localStorage.getItem("user");
const initialState = stateInStorage ? JSON.parse(stateInStorage) : null;

const [_useGlobalUser, Provider] = createGlobalState(initialState);

function useGlobalUser() {
  const [_user, _setUser] = _useGlobalUser();

  function setUser(user) {
    _setUser(user);
    localStorage.setItem("user", JSON.stringify(user));
  }

  return [_user, setUser];
}

export const GlobalUserProvider = Provider;
export default useGlobalUser;
