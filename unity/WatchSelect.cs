using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;


public class WatchSelect : MonoBehaviour
{
    public GameObject watch1;//watchModel1
    public GameObject watch2;//watchModel2
    public GameObject watch3;//watchModel3
    
    public GameObject watch1window;//canvas->window1
    public GameObject watch2window;
    public GameObject watch3window;

    Animation w1WindowAnimation; // pt animare selectie ceas (aducerea in cadru a windowului pentru care am creat animatiile)
    Animation w2WindowAnimation;
    Animation w3WindowAnimation;

     // Start is called before the first frame update
    void Start() // e calluita la inceperea programului
    {
        w1WindowAnimation = watch1window.GetComponent<Animation>();
        w2WindowAnimation = watch2window.GetComponent<Animation>();
        w3WindowAnimation = watch3window.GetComponent<Animation>();

    }

    public void Watch1WindowDisable() 
    {
        watch1window.SetActive(false);
    }
 
    public void Watch2WindowDisable() 
    {
        watch2window.SetActive(false);
    }

    public void Watch3WindowDisable() 
    {
        watch3window.SetActive(false);
    }


    public void Watch1ButtonClicked(){

        watch1window.SetActive(true);
        // 1. show watch model 1 pe mana userului
        watch1.SetActive(true);
        watch2.SetActive(false); //afiseaza doar modelul 1 de ceas, pe celelalte le ascunde
        watch3.SetActive(false);



        // // 2. animate watch window 1
        // w1WindowAnimation["w1animation"].speed=1; // ce e intre [] trb sa fie numele exact al animatiei din unity assets
        // w1WindowAnimation.Play();
    }

    public void Watch2ButtonClicked(){
        watch2window.SetActive(true);
        // 1. show watch model 2 pe mana userului
        watch2.SetActive(true);
        watch1.SetActive(false);
        watch3.SetActive(false);
        // 2. animate watch window 2
        // w2WindowAnimation["w2animation"].speed=1;
        // w2WindowAnimation.Play();
    }

    public void Watch3ButtonClicked(){
        watch3window.SetActive(true);
        // 1. show watch model 3 pe mana userului
        watch3.SetActive(true);
        watch1.SetActive(false);
        watch2.SetActive(false);

        // // 2. animate watch window 3
        // w3WindowAnimation["w3animation"].speed=1;
        // w3WindowAnimation.Play();
    }

}
