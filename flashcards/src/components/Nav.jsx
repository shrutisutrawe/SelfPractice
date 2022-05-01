import { useState } from 'react';

function Nav({page, setPage, onLogout, isLoggedIn, onUsernameChange, onPasswordChange, onLogin, errorStatus, setSuccessStatus}) {
    
    const [navLinkOpen,navLinkToggle] = useState(false);
    const handleClick=() =>{
        navLinkToggle(!navLinkOpen);
    };
     
    function navTo(e, target) {
        e.preventDefault();
        const url = '/'+target;
        window.history.pushState({},"",url);
        setPage(target);
        setSuccessStatus(false);
    };

    function errorPage(){
        return(
            <div className='error-panel'>{errorStatus}<br/>
            <a href="#" onClick={(e) =>{navLinkToggle(!navLinkOpen); navTo(e, '#'); onLogout()}}>login back</a>
            </div>
            
        )
    }

    function  Login() {
        return(
            <div className="login-main-div">
              {errorStatus && <div className="error-panel">{errorPage()}</div>}
              
              
              { !errorStatus && <div>
                  <h3>Login</h3>
                  <form onSubmit={e => {e.preventDefault();}}>
                  <input type="text" onChange={(e)=>{onUsernameChange(e)}} placeholder="Enter Username" name="username"></input><br />
                  <input type="password" onChange={(e)=>{onPasswordChange(e)}} placeholder="Enter Password" name="password"></input><br />
                  <button className="login-btn" onClick={(e)=> {onLogin();navLinkToggle(!navLinkOpen); navTo(e, '#Home');}}  > Login </button>
              </form> </div>}
            </div>
        );
        
    };
    
    return (
            <div className="container">
                <div className='background-image'></div>
                <nav>
                    <div className='navigation'>
                        { !isLoggedIn && <div className='login-panel'>
                            <div className='header'>
                                <h2>Welcome to Qwick FlashCards</h2>
                            </div>
                            {Login()}
                            </div>}
                        { isLoggedIn && (page != "#") &&
                        <div className = "nav-list">
                            <button aria-label = "menu button" onClick={handleClick} className = "nav-icon">
                            &#9776;
                            </button>
                            <ul className = {navLinkOpen ? "nav-menu active":"nav-menu"} >
                                <li className="nav-item"><a href="#Home" onClick={(e) => {navLinkToggle(!navLinkOpen); navTo(e, '#Home');}}>Home</a></li>
                                <li className="nav-item"><a href="#New" onClick={(e) => {navLinkToggle(!navLinkOpen); navTo(e, '#New');}}>New</a></li>
                                <li className="nav-item"><a href="#Cards" onClick={(e) => {navLinkToggle(!navLinkOpen); navTo(e, '#Cards');}}>Cards</a></li>
                                <li className="nav-item"><a href="#Practice" onClick={(e) =>{navLinkToggle(!navLinkOpen); navTo(e, '#Practice');}}>Practice</a></li>
                                <li className="nav-item"><a href="#" onClick={(e) =>{navLinkToggle(!navLinkOpen); navTo(e, '#'); onLogout()}}>Logout</a></li>
                            </ul>
                        </div>}
                    </div>
                </nav>
             </div>
    );
}
export default Nav;


