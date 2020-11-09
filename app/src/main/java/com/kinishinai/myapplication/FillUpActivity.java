package com.kinishinai.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class FillUpActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout linearAddComponent, linearAddComponentEditor, linearAddComponentTranslator;
    private EditText edtTextAuthorFirst1, edtTextAuthorLast1, edtEditorFirst, edtEditorLast, edtTranslatorFirst, edtTranslatorLast, edtBookTitle, edtEdition, edtVolume, edtPublisher, edtYear, edtPages;
    private Button btnAdd, btnAPA, buttonEditorAdd, buttonTranslatorAdd;
    private RelativeLayout relativeParentAPAFillUp;
    private ArrayList<AuthorNameDynamically>authorNameList = new ArrayList<>();
    private  ArrayList<EditorNameDynamically>editorNameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_up);

        relativeParentAPAFillUp = findViewById(R.id.relative_parent_apa_fillup);

        linearAddComponent = findViewById(R.id.linearAddComponent);
        linearAddComponentEditor = findViewById(R.id.linearAddComponentEditor);
        linearAddComponentTranslator = findViewById(R.id.linearAddComponentTranslator);

        edtTextAuthorFirst1 = findViewById(R.id.edtTextAuthorFirst1);
        edtTextAuthorLast1 = findViewById(R.id.edtTextAuthorLast1);
        edtEditorFirst = findViewById(R.id.edtEditorFirst);
        edtEditorLast = findViewById(R.id.edtEditorLast);
        edtTranslatorFirst = findViewById(R.id.edtTranslatorFirst);
        edtTranslatorLast = findViewById(R.id.edtTranslatorLast);
        edtBookTitle = findViewById(R.id.edtJournalTitle);
        edtEdition = findViewById(R.id.edtVolume);
        edtVolume = findViewById(R.id.edtNumber);
        edtPublisher = findViewById(R.id.edtYear);
        edtYear = findViewById(R.id.edtArticleTitle);
        edtPages = findViewById(R.id.edtPages);

        btnAdd = findViewById(R.id.btnAdd);
        btnAPA = findViewById(R.id.btnAPA);
        buttonEditorAdd = findViewById(R.id.buttonEditorAdd);
        buttonTranslatorAdd = findViewById(R.id.buttonAddTranslator);

        buttonEditorAdd.setOnClickListener(this);
        buttonTranslatorAdd.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnAPA.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_clear,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.clear_menu:
                edtTextAuthorFirst1.setText("");
                edtTextAuthorLast1.setText("");
                edtEditorFirst.setText("");
                edtEditorLast.setText("");
                edtTranslatorFirst.setText("");
                edtTranslatorLast.setText("");
                edtBookTitle.setText("");
                edtEdition.setText("");
                edtVolume.setText("");
                edtPublisher.setText("");
                edtYear.setText("");
                edtPages.setText("");

                for (int i=0; i<linearAddComponent.getChildCount(); i++){
                    View authorNameView = linearAddComponent.getChildAt(i);
                    EditText edtTextFirst = (EditText)authorNameView.findViewById(R.id.addEdtTextAuthorFirstName);
                    EditText editTextLast = (EditText)authorNameView.findViewById(R.id.addEdtTextAuthorLastName);
                    edtTextFirst.setText("");
                    editTextLast.setText("");
                }
                Toast.makeText(this, "clear", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAPA:
                //author name format
                String firstNameAuthor = "";
                String lastNameAuthor = "";
                //editor
                String editorFirst = "";
                String editorLast = "";
                //translator
                String translatorFirst = "";
                String translatorLast = "";

                // book title italic
                String bookTitle = edtBookTitle.getText().toString();
                //edition
                String edition = edtEdition.getText().toString();

                //volume
                String volume = edtVolume.getText().toString();
                // pages
                String pages = edtPages.getText().toString();
                // publisher
                String publisher = edtPublisher.getText().toString();
                // year
                String year = edtYear.getText().toString();
                //other declaration
                String newEdition;
                int editionIntType;
                // format
                String workCitatedResult1 = "";
                String workCitatedResult2 = "";
                String inTextCitatedResult = "";
                //if's
                //TODO fuck
                if(edtTextAuthorFirst1.getText().toString().equals("")) {
                    Toast.makeText(this, "fuck", Toast.LENGTH_SHORT).show();
                    break;
                }
                else
                    firstNameAuthor = edtTextAuthorFirst1.getText().toString().substring(0,1).toUpperCase();
                if(edtTextAuthorLast1.getText().toString().equals("")) {
                    showFillUpMessage();
                    break;
                }
                else{
                    String capitalLastName = edtTextAuthorLast1.getText().toString().substring(0,1).toUpperCase();
                    lastNameAuthor = capitalLastName+edtTextAuthorLast1.getText().toString().substring(1);
                }

                if(bookTitle.equals("")){
                    showFillUpMessage();
                    break;
                }

                if(edition.equals("")) {
                    showFillUpMessage();
                    break;
                }
                else {
                    editionIntType = Integer.parseInt(edition);
                    newEdition = addOrdinalSuffix(editionIntType);
                }
                if(publisher.equals("")) {
                    showFillUpMessage();
                    break;
                }
                if(pages.equals("")) {
                    showFillUpMessage();
                    break;
                }
                if(year.equals("")) {
                    showFillUpMessage();
                    break;
                }
                if(volume.equals("")){
                    if(edtEditorFirst.getText().toString().equals("") && edtEditorLast.getText().toString().equals("")) {
                        if(edtTranslatorFirst.getText().toString().equals("") && edtTranslatorLast.getText().toString().equals("")) {
                            workCitatedResult1 = lastNameAuthor + ", " + firstNameAuthor + ". (" + year + "). ";
                            workCitatedResult2 = ". (" + newEdition + " ed., " + pages + ".). " + publisher + ".";
                            inTextCitatedResult = "(" + lastNameAuthor + ", " + year + ")";
                        }else{
                            translatorFirst = edtTranslatorFirst.getText().toString().substring(0,1).toUpperCase();
                            translatorLast = edtTranslatorLast.getText().toString();
                            workCitatedResult1 = lastNameAuthor + ", " + firstNameAuthor + ". (" + year + "). ";
                            workCitatedResult2 = ". ("+translatorFirst+". "+translatorLast+" Trans."+") ("
                                    + newEdition + " ed., " + pages + ".). " + publisher + ".";
                            inTextCitatedResult = "(" + lastNameAuthor + ", " + year + ")";
                        }
                    }
                    else {
                        if(edtTranslatorFirst.getText().toString().equals("") && edtTranslatorLast.getText().toString().equals("")) {
                            editorFirst = edtEditorFirst.getText().toString().substring(0, 1);
                            editorLast = edtEditorLast.getText().toString();
                            workCitatedResult1 = lastNameAuthor + ", " + firstNameAuthor + ". (" + year + "). ";
                            workCitatedResult2 = ". (" + editorFirst + ". " + editorLast + " Ed." + ") (" + newEdition + " ed., " + pages + ".). " + publisher + ".";
                            inTextCitatedResult = "(" + lastNameAuthor + ", " + year + ")";
                        }
                        else {
                            editorFirst = edtEditorFirst.getText().toString().substring(0, 1);
                            editorLast = edtEditorLast.getText().toString();
                            translatorFirst = edtTranslatorFirst.getText().toString().substring(0,1).toUpperCase();
                            translatorLast = edtTranslatorLast.getText().toString();
                            workCitatedResult1 = lastNameAuthor + ", " + firstNameAuthor + ". (" + year + "). ";
                            workCitatedResult2 = ". (" + editorFirst + ". " + editorLast + " Ed., "+translatorFirst+"."
                                    +translatorLast+" Trans.) (" + newEdition + " ed., " + pages + ".). " + publisher + ".";
                            inTextCitatedResult = "(" + lastNameAuthor + ", " + year + ")";
                        }
                    }
                }
                else{
                    if(edtEditorFirst.getText().toString().equals("") && edtEditorLast.getText().toString().equals("")) {
                        if(edtTranslatorFirst.getText().toString().equals("") && edtTranslatorLast.getText().toString().equals("")) {
                            workCitatedResult1 = lastNameAuthor + ", " + firstNameAuthor + ". (" + year + "). ";
                            workCitatedResult2 = ". (" + newEdition + " ed., Vol. " + volume + ", " + pages + ".). " + publisher + ".";
                            inTextCitatedResult = "(" + lastNameAuthor + ", " + year + ")";
                        }
                        else{
                            translatorFirst = edtTranslatorFirst.getText().toString().substring(0,1).toUpperCase();
                            translatorLast = edtTranslatorLast.getText().toString();
                            workCitatedResult1 = lastNameAuthor + ", " + firstNameAuthor + ". (" + year + "). ";
                            workCitatedResult2 = ". ("+translatorFirst+". "+translatorLast+" Trans."
                                    +") (" + newEdition + " ed., Vol. " + volume + ", " + pages + ".). " + publisher + ".";
                            inTextCitatedResult = "(" + lastNameAuthor + ", " + year + ")";
                        }
                    }
                    else{
                        if(edtTranslatorFirst.getText().toString().equals("") && edtTranslatorLast.getText().toString().equals("")){
                            editorFirst = edtEditorFirst.getText().toString().substring(0, 1);
                            editorLast = edtEditorLast.getText().toString();
                            workCitatedResult1 = lastNameAuthor + ", " + firstNameAuthor + ". (" + year + "). ";
                            workCitatedResult2 = ". ("+editorFirst+". "+editorLast+" ed."
                                    +") (" + newEdition + " ed., Vol. " + volume + ", " + pages + ".). " + publisher + ".";
                            inTextCitatedResult = "(" + lastNameAuthor + ", " + year + ")";
                        }
                        else{
                            editorFirst = edtEditorFirst.getText().toString().substring(0, 1);
                            editorLast = edtEditorLast.getText().toString();
                            translatorFirst = edtTranslatorFirst.getText().toString().substring(0,1).toUpperCase();
                            translatorLast = edtTranslatorLast.getText().toString();
                            workCitatedResult1 = lastNameAuthor + ", " + firstNameAuthor + ". (" + year + "). ";
                            workCitatedResult2 = ". (" + editorFirst + ". " + editorLast + " Ed., "+translatorFirst+"."
                                    +translatorLast+" Trans.) (" + newEdition + " ed., Vol. "
                                    + volume + ", " + pages + ".). " + publisher + ".";
                            inTextCitatedResult = "(" + lastNameAuthor + ", " + year + ")";
                        }
                    }
                }
                String lastFullName="";
                if(isValidateAuthorName()){
                    String fullName = "";
                    if(authorNameList.size()<2){
                        lastFullName = "& "+authorNameList.get(0).getAuthorLastName()+", "+authorNameList.get(0).getAuthorFirstname().substring(0,1).toUpperCase()+". ";
                        workCitatedResult1 = lastNameAuthor+", "+firstNameAuthor+"., "+lastFullName+"("+year+"). ";
                    }else {
                        String getLastValueInArraylist = "& "+authorNameList.get(authorNameList.size()-1).getAuthorLastName()+", "+authorNameList.get(authorNameList.size()-1).getAuthorFirstname().substring(0,1).toUpperCase()+". ";
                        for (int i = 0; i < authorNameList.size()-1; i++) {
                            fullName += authorNameList.get(i).getAuthorLastName() + ", " + authorNameList.get(i).getAuthorFirstname().substring(0, 1).toUpperCase() + "., ";
                            workCitatedResult1 = lastNameAuthor + ", " + firstNameAuthor + "., " + fullName +getLastValueInArraylist+ "(" + year + "). ";
                        }
                        inTextCitatedResult = "("+lastNameAuthor+" et al., "+year+")";
                    }
                }
                else{
                    Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
                }


                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("work1", workCitatedResult1);
                intent.putExtra("work2", workCitatedResult2);
                intent.putExtra("bookTitle", bookTitle);
                intent.putExtra("inText", inTextCitatedResult);
                this.startActivity(intent);

                break;
            case R.id.btnAdd:
                addEditTextView();
                break;
            case R.id.buttonEditorAdd:
                addEditTextViewEditor();
                break;
            case R.id.buttonAddTranslator:
                addEditTextViewTranslator();
                break;

        }
    }
    private boolean isValidateEditor(){
        editorNameList.clear();

        boolean result = true;

        for (int i=0; i<linearAddComponentEditor.getChildCount(); i++){
            View editorNameView = linearAddComponentEditor.getChildAt(i);
            EditText edtTextEditorFirst = (EditText)editorNameView.findViewById(R.id.editTextTextEditorFirst);
            EditText edtTextEditorLast = (EditText)editorNameView.findViewById(R.id.editTextEditorLast);

            if(!edtTextEditorFirst.getText().toString().equals("") || !edtTextEditorLast.getText().toString().equals("")){
                editorNameList.add(new EditorNameDynamically(edtTextEditorFirst.getText().toString(),edtTextEditorLast.getText().toString()));
            }
            else{
                result = false;
                break;
            }
        }
        if (editorNameList.size() == 0){
            result = false;
        }
        return result;
    }
    private boolean isValidateAuthorName() {
        authorNameList.clear();
        boolean result = true;

        for (int i=0; i<linearAddComponent.getChildCount(); i++){
            View authorNameView = linearAddComponent.getChildAt(i);
            EditText edtTextFirst = (EditText)authorNameView.findViewById(R.id.addEdtTextAuthorFirstName);
            EditText editTextLast = (EditText)authorNameView.findViewById(R.id.addEdtTextAuthorLastName);

            if(!edtTextFirst.getText().toString().equals("") || !editTextLast.getText().toString().equals("")){
                authorNameList.add(new AuthorNameDynamically(edtTextFirst.getText().toString(),editTextLast.getText().toString()));
            }
            else{
                result = false;
                break;
            }
        }
        if(authorNameList.size()==0){
            result = false;
        }
        return result;
    }

    private void showFillUpMessage() {
        Snackbar.make(relativeParentAPAFillUp,"fill up all the edit text to proceed", BaseTransientBottomBar.LENGTH_SHORT).show();
    }

    private void addEditTextViewTranslator() {
        final View translatorNameAddEdtText = getLayoutInflater().inflate(R.layout.tranlator_name_add,null,false);
        EditText edtTextTranslatorFirst = (EditText)translatorNameAddEdtText.findViewById(R.id.editTextTextTranslatorFirst);
        EditText edtTextTranslatirLast = (EditText)translatorNameAddEdtText.findViewById(R.id.editTextTranslatorLast);
        ImageButton buttonRemoveTranslator = (ImageButton)translatorNameAddEdtText.findViewById(R.id.imageButtonReduceTranslator);

        buttonRemoveTranslator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeEditTextViewTranslator(translatorNameAddEdtText);
            }
        });

        linearAddComponentTranslator.addView(translatorNameAddEdtText);
    }

    private void addEditTextViewEditor() {
        final View editorNameAddEdtText = getLayoutInflater().inflate(R.layout.editor_name_add, null,false);
        EditText edtTextEditorFirst = (EditText)editorNameAddEdtText.findViewById(R.id.editTextTextEditorFirst);
        EditText edtTextEditorLast = (EditText)editorNameAddEdtText.findViewById(R.id.editTextEditorLast);
        ImageButton buttonEditorRemove = (ImageButton)editorNameAddEdtText.findViewById(R.id.imageButtonReduceEditor);

        buttonEditorRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeEditTextViewEditor(editorNameAddEdtText);
            }
        });

        linearAddComponentEditor.addView(editorNameAddEdtText);
    }

    private void addEditTextView(){

        final View authorNameAddEdtText = getLayoutInflater().inflate(R.layout.author_name_add, null, false);
        EditText edtTextFirst = (EditText)authorNameAddEdtText.findViewById(R.id.addEdtTextAuthorFirstName);
        EditText editTextLast = (EditText)authorNameAddEdtText.findViewById(R.id.addEdtTextAuthorLastName);
        ImageButton authorRemove = (ImageButton)authorNameAddEdtText.findViewById(R.id.imageButtonReduceAuthor);

        authorRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeEditTextView(authorNameAddEdtText);
            }
        });

        linearAddComponent.addView(authorNameAddEdtText);

    }

    private void removeEditTextView(View view){
        linearAddComponent.removeView(view);
    }
    private void removeEditTextViewEditor(View view){
        linearAddComponentEditor.removeView(view);
    }
    private void removeEditTextViewTranslator(View view){
        linearAddComponentTranslator.removeView(view);
    }

    private String addOrdinalSuffix(int edition){
        int editionSuffix = edition % 10;
        int editionSuffix2 = edition % 100;
        if (editionSuffix == 1 && editionSuffix2 != 11)
            return edition+"st";
        if (editionSuffix == 2 && editionSuffix2 != 12)
            return edition+"nd";
        if (editionSuffix == 3  && editionSuffix2 != 13)
            return edition+"rd";
        return edition+"th";
    }
}