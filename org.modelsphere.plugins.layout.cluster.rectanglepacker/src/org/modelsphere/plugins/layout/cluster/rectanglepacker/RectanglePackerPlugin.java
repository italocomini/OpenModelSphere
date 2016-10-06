package org.modelsphere.plugins.layout.cluster.rectanglepacker;

import java.util.ArrayList;
import java.util.List;

import org.modelsphere.jack.srtool.features.layout.LayoutAlgorithm;
import org.modelsphere.jack.srtool.features.layout.LayoutPlugin;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class RectanglePackerPlugin extends LayoutPlugin {
    private RectanglePackerAlgorithm rectanglePackerAlgorithm;

    @Override
    public List<LayoutAlgorithm> getLayoutAlgorithms() {
        if (rectanglePackerAlgorithm == null)
            rectanglePackerAlgorithm = new RectanglePackerAlgorithm();

        ArrayList<LayoutAlgorithm> algorithms = new ArrayList<LayoutAlgorithm>();
        algorithms.add(rectanglePackerAlgorithm);
        return algorithms;
    }

	@Override
	public List<LayoutAlgorithm> getDefaultLayoutAlgorithms() {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
//		return null;
	}

}
