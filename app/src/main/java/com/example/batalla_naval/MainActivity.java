package com.example.batalla_naval;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Tamaño del tablero
    private final int numRows = 8;
    private final int numCols = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Referencia al TableLayout
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Crear las filas y columnas dinámicamente
        for (int row = 0; row < numRows; row++) {
            TableRow tableRow = new TableRow(this);
            tableLayout.addView(tableRow);

            for (int col = 0; col < numCols; col++) {
                Button button = new Button(this);
		
                // Definir el texto del botón como coordenada (ej: A1, B2, etc.)
                String coordinate = "" + (char) ('A' + row) + (col + 1);
                button.setLayoutParams(new TableRow.LayoutParams(100, 100));
                button.setText(coordinate);

                // Establecer un estilo para los botones
                button.setBackgroundResource(R.drawable.border);

                // Manejar el clic en el botón
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Casilla clicada: " + coordinate, Toast.LENGTH_SHORT).show();
                    }
                });

                // Añadir el botón a la fila
                tableRow.addView(button);
            }
        }
    }
}

