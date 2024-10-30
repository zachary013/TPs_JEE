package actions;

import hibernate.Professeur;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import Traitement.TestMain;
import beans.UserinputForm;

public class UserinputAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        UserinputForm userinputForm = (UserinputForm) form;

        Professeur prof = new Professeur();
        prof.setNom(userinputForm.getNom());
        prof.setPrenom(userinputForm.getPrenom());
        prof.setAdresse(userinputForm.getEmail());

        TestMain test = new TestMain();
        test.AjouterProfesseur(prof);

        HttpSession session = request.getSession(true);
        session.setAttribute("user", userinputForm);

        return mapping.findForward("succes");
    }
}
