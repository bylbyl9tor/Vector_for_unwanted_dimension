package VectorMassiv;

import java.util.Arrays;

public class VectorMassiv {
    private double vector[];
    VectorMassiv(double []vector)
    {
        this.vector = Arrays.copyOf(vector, vector.length);
    }
    public double length() {
        double sum=0;
        for(double i: vector)
        {
            sum+=+i*i;
        }
        return Math.sqrt(sum);
    }
    public double scalarProduct(VectorMassiv secondVector) {
        double sum = 0;

        for (int i = 0; i < vector.length; i++) {
            sum += this.vector[i] * secondVector.vector[i];
        }
        return sum;
    }
    public double cos(VectorMassiv secondVector) {
        return scalarProduct(secondVector) / (length() * secondVector.length());
    }
    public VectorMassiv add(VectorMassiv secondVector) {
        double[]cupMassiv=new double[vector.length];
        for(int i=0;i<vector.length;i++)
        {
            cupMassiv[i]=this.vector[i]+secondVector.vector[i];
        }
        return new VectorMassiv(cupMassiv);
    }

    public VectorMassiv substract(VectorMassiv secondVector) {
        double[]cupMassiv=new double[vector.length];
        for(int i=0;i<vector.length;i++)
        {
            cupMassiv[i]=this.vector[i]-secondVector.vector[i];
        }
        return new VectorMassiv(cupMassiv);
    }

    private static double[] generateRandomArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    public static VectorMassiv[] generate(int n, int dimension) {
        VectorMassiv[] vectors = new VectorMassiv[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new VectorMassiv(generateRandomArray(dimension));
        }
        return vectors;
    }

    @Override
    public String toString() {
        String cupString="";
        for(double i: vector)
            cupString+=Double.toString(i)+" ";
        return "Vector{" +cupString+ '}';
    }
}
